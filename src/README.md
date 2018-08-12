# Spring - AOP

##1. 切点表达式函数

Spring支持9个@AspectJ切点表达式函数，它们用不同的方式描述目标类的连接点 
根据描述对象的不同，大致可以分为4类

* 方法切点函数：通过描述目标类方法的信息定义连接点
* 方法入参切点函数：通过描述目标类方法入参的信息定义连接点
* 目标类切点函数：通过描述目标类类型的信息定义连接点
* 代理类切点函数：通过描述目标类的代理类的信息定义连接点

###1. 方法切点函数
execution()
入参：方法匹配模式串

说明：表示满足某一匹配模式的所有目标类方法连接点，如 execution(* greetTo(..))表示所有目标类中的greetTo()方法，greetTo()方法可以带带任意的入参和任意的返回值

@annotation()
入参：方法注解类名

说明：表示标注了某特定注解的目标类方法连接点， 比如@annotation(com.xgj.annotation.NeedTest)表示任何标注了@NeedTest注解的目标类方法。

###2. 方法入参切点函数
args()
入参：类名

说明：通过判断目标类方法运行时入参对象的类型定义指定连接点，如args(com.xgj.Waiter)表示所有有且仅有一个按类型匹配于Waiter入参的方法。

@args()
入参：类型注解类型

说明：通过判断目标类方法运行时入参对象的类是否标注了特定的注解指定连接点。 比如@args(com.xgj.Monitor)表示任何这样的一个目标方法，它有一个入参且入参对象的类标注@Monitor注解

###3. 目标类切点函数
within()
入参：类名匹配串

说明：表示特定域下的所有连接点，比如 within(com.xgj.service.*)表示com.xgj.service包中所有的连接点，即包中所有类的所有方法； 而 within(com.xgj.service.*Service)表示在com.xgj.service包中所有以Service结尾的类的所有连接点

target()
入参：类名

说明：假如目标类按类型匹配与指定类，则目标类的所有连接点匹配这个切点。 比如通过target(com.xgj.Waiter)定义的切点，Waiter及Waiter实现类NaiveWaiter中的所有连接点都匹配该切点

@within()
入参：类型注解类名

说明：假如目标类按类型匹配于某个类A，且类A标注了特定的注解，这目标类的所有连接点匹配这个切点。 比如@within(com.xgj.Monitor)定义的切点，加入Waiter实现了@Monitor注解，这Waiter及Waiter的实现类NaiveWaiter的说哟连接点都匹配这个切点

@target()
入参：类型注解类名

说明：假如目标类标注了特定注解，则目标类的所有连接点都匹配该切点。 如@target(com.xgj.Monitor),假设NaiveWaiter标注了@Monitor注解，则NaiveWaiter的所有连接点都匹配这个切点

###4. 代理类切点函数
this
入参：类名

说明：代理类按类型匹配于指定类，则被代理的目标类的所有连接点都匹配该切点。

##2. 在函数入参中使用通配符
有些函数的入参可以接受通配符，@AspectJ支持三种通配符

*
* 表示匹配任意字符，但它只能匹配上下文中的一个元素

..
..表示匹配任意字符，可以匹配上下文中的 多个元素， 但在标识类时，必须和 * 联合使用，而在表示入参时则单独使用

+
+表示按照类型匹配指定类的所有类，必须跟在类名后面，比如com.xgj.Service+。 继承或扩展指定类的所有类，同时还包含指定类本身。

支持通配符的函数说明
* 支持所有通配符 execution()和within() , 比如within(com.xgj.*) within(com.xgj.service..*.*Service+)

* 仅支持“+”通配符： args()、this()和target(). 比如args(com.xgj.Waiter+) 、target(java.util.List+)等。 虽然支持+通配符，但是意义不大。 对于这些函数来讲使用+和不使用+是等价的

* 不支持通配符： @args()、@within、@target 和 @annotation.

##3. @target 与 @within区别
父类有注解，但子类没有注解的话，@within和@target是不会对子类生效的。
子类没有注解的情况下，只有没有被重写的有注解的父类的方法才能被@within匹配到。
如果父类无注解，子类有注解的话，@target对父类所有方法生效，@within只对重载过的方法生效。

##4.target 与 within区别
target不支持通配符
within支持通配符