## 固定行录入表

产品介绍 github地址：https://github.com/blueskylong/aolie_illustrate

```固定行录入表是表格的列固定，行数据内置部分内容，且可能存在向上汇总的一类输入表。一般内置数据的结构,再在结构上增加,修改,删除.```

#### 固定行录入表在普通表的基础上,需要确定几个方面的额外配置信息
1. 哪些列具有固定列的内容
2. 固定的内容有哪些
3. 哪些列是固定内容的分组，如：固定内容按单位分别生成一份，此时，单位即为分组列，如果没有设置分组列，则整个平台里只有一份。
4. 哪些列需要向上汇总

其中，指定固定列和哪些列需要向上汇总，属于表列本身的属性，所以集成在列定义中。而固定列的内容，则另外开发一个功能进行维护。
![增加的列属性](https://github.com/blueskylong/aolie_illustrate/blob/master/images/fixRow/addAttr.png)
#### 固定列内容维护功能的开发思路是：
1. 配置信息与业务信息的关联
每一个业务表，会有不同的字段，而记录固定列数据，是一张固定的表，固定的字段，此表中内置了一些通用字段，如以F开头的字段表示浮点字段，C开头的为字符列等，业务表需要与固定数据表的字段相对应，以便双向转换。
当前采用自动关联的方式进行，根据固定列的类型，自动分配通用字段，如果有修改，则优先使用原来字段，只有类型变化，才会重新分配新的字段。
字段关联的作用是，1,在维护固定表内容时，将业务表的内容转换到固定表中。2，在业务表录入前，将固定表中的内容，插入到业务表中。
![内容配置](https://github.com/blueskylong/aolie_illustrate/blob/master/images/fixRow/content.png)

2. 固定行的控制信息
固定行有以下几个控件信息：
a: 是否其中数：表示此行的数据，向不向上汇总。
b: 可插下级:指定此行是否可以插入下级行，只允许增加一级下级，即下级不可以再增加下级。
c: 可以删除:此固定行是否可以删除，
d: 汇总下级:是否此列需要向上汇总的功能

#### 固定行输入
固定行输入，在普通录入表的基础上，增加了一些控制
a: 查询时，如果查询返回为空数据，则要先生成一份固定行数据，然后再查询一次。查询会根据设置信息来拼出控制信息，控制信息不存储在业务表中。
b: 录入时，除了普通的列公式外，还要处理向上汇总功能
c: 保存时，需要检查控制信息，并验证数据是否符合控制信息，计算公式，及向上汇总。
![内容配置](https://github.com/blueskylong/aolie_illustrate/blob/master/images/fixRow/busi.png)



