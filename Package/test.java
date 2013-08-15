　　public class Man

　　{

　　//对属性的封装，一个人的姓名，年龄，妻子都是这个对象（人）的私有属性

　　private String name;
　　private int age;
　　private Woman wife;

　　//对改人对外界提供方法的封装，可以设定妻子，姓名，年龄也可以获得男人的姓名和年龄

　　public void setWife(Woman wife)
　　{
		this.wife = wife;
　　}
	
　　public String getName()
　　{
		return name;
　　}

　　public void setName(String name)
　　{
		this.name = name;
　　}

　　public int getAge()
　　{
		return age;
　　}

　　public void setAge(int age)
　　{
		this.age     = age;
　　}

　　}
　　public class Woman
　　{
	// 　　属性封装

	　　private String name;
	　　private int age;
	　　private Man husband;

// 　　	方法封装
　　public String getName()
　　{
		return name;
　　}

　　public void setName(String name)
　　{
		this.name    = name;
　　}

　　public int getAge()
　　{
		return age;
　　}

　　public void setAge(int age)
　　{
　　this.age     = age;
　　}

　　public Man getHusband()
　　{
　　return husband;
　　}

　　public void setHusband(Man husband)
　　{
　　this.husband = husband;
　　}
　　}

　　/**

　　* 仔细看就会发现，Man类没有提供getWife的方法，这是以为男人不想让自己的妻子被外界访问，

　　* 直接下来呢，就是封装可以吧一个对象的属性私有，而提供一些可以被外界访问的属性的方法，

　　* 比如说，name属性，Man和Woman类都有相应的get和set方法，外界都可以通过这些方法访问和修改

　　* 同时对一些改对象不想让外界访问的属性，就不提供其方法，比如说Man的wife属性，就没有get方法

　　* 外界是不能带到Man类的wife属性的

　　*/

　　上面那例子可能没有突出封装的好处，下面来个超简单的表达下：

　　public class Show
　　{
　　public static void show(String str)
　　{
　　System.out.println(str);
　　}
　　}

　　上面就是对 System.out.println();的封装。

　　调用的时候 ：

　　public class Use
　　{
　　public static void main(String[] args)
　　{
　　Show.show("封装")；
　　}
　　}

　　这样用的时候就不用使：System.out.println("封装")；

　　如果还有地方用到， 就省去了好多 System.out.println();

　　n 简而言之，有一段代码，如果3个程序要用它，你不封装，那你就得在这3个程序里都要写，浪费代码，浪费时间。
