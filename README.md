# hello_world-
hello
//great start!

lists to do:
java common mode
socket communication
multiThreads
python
kotlin
blockChain
id3 format
chunk prase

at least 50 lines per day!



读取公司规章制度和流程
从中了解公司价值取向，定制管理个人工作节奏
规范的流程制度能够托起下限，付出少量的效率代价避免重大问题，毕竟谷歌只有一个

一个合格的开发不应该将立场位于测试等其他部门的对立面 应该了解其他部门的工作，明确工作任务和职责
review机制与每周技术例会
一次议题15到20分钟PPT  集中精神提升效率精炼内容

不把同事当google用
c++有指针和偏移的概念，虽然不能本能的写出某个具体偏移，查一下测一下就OK了


————————————————————————————————————————————————————————————
SDK   callback机制
MVC架构与设计模式 常用的数据结构、算法及架构
ANR CRASH
多屏适配

activity的启动模式：默认标准模式，singleTop模式，singleTask模式，singleInstance模式(单独的返回栈)

来源：https://blog.csdn.net/sinat_22657459
binder机制体现：
Activity.startActivity()->Activity.startActivityForResult(){
mInstrumentation.execStartActivity;//将Activity的启动数据封装完成后，通过binder机制发送到Server端，也就是AMS
mMainThread.sendActivityResult}//判断调用正常的情况下，通知应用主线程ActivityThread来处理启动后的结果
execStartActivity(){
ActivityManager.getService()//获取binder代理对象
.startActivity;//启动目标activity
}

service的启动方式：
startService(intent)由活动来决定什么时候停止服务;
service里面创建个binder的子类放入onbinder()，在activity写一个ServiceConnection()然后bindService()
只有通过startService()方法启动service服务时才会调用onStart()方法。

多线程安全和解决:一个方法或者一个实例可以在多线程环境中使用而不会出现问题.原子类，同步关键字，锁，线程安全集合等。

activity生命周期之外还有哪些可用的接口：
activity被销毁后的数据保留：onSaveInstanceState()方法会携带一个Bundle类型的参数，Bundle提供了一系列的方法用于保存数据，比如可以使用putString()方法保存字符串
在activity中重写onSaveInstanceState(Bundle outState)方法就可以进行数据保存，在onCreate里面的Bundle参数中取出数据


开发难点：
单一功能总有多个途径去实现，怎么保证低耦合高效率易维护；解耦解耦
多线程的运行经常出现意外，对多线程的掌控是一个难点。
____________________________________
周五下午4点
android UI视图绘制机制和动画机制 网络模块开发
常用设计模式：一个简单高效的功能代码块天然的具备了一些设计模式的特点，比如监听器和MVC中更新数据的那块，就是一个观察者模式的具体实现。
activity的启动模式就有单例模式的思想。适配器模式就更不用说了。因此android系统源码是我们开发的重要参考点。
直接使用android已有的功能和开源的功能模块是实现某个功能的首选，而不是自己去实现。

----------------------------
周六下午 
GUI开发
HTML/HTTP
终端网络编程/3gwifi技术
socket
JNI

_________________________________________________________
来源：https://blog.csdn.net/wo_sxn/article/details/77587374
MediaCodec调用ACodec的initiateAllocateComponent接口进编解码组件的创建:
1 omx client连接Omx：OMXClient.connect()    从media.player和media.codec服务获取iomx的bp代理对象，并且封装在MuxOMX中，返回给ACodec的就是mOMX变量
2 获取omx bp代理对象
3 allocate node           实例化OmxNodeInstance存放关键信息比如生成的节点id(mNodeID)、ACodec传递下来的observer、plugin里创建的解码组件handle和构造OMXNodeInstance时传入的omx对象等
omxclient连接omx，通过interface接口将连接过程中获取到omx bp对象返回给ACodec保存并使用
acodec在创建编解码组件的过程中，通过omxclient拿到omx bp代理对象，根据这个代理对象和omx进行通信。omx接收到ALLOCATE_NODE的请求后，调用allocateNode()接口进一步通知plugin创建对应的编解码组件，并返回其操作句柄，后面就是操作这个句柄来工作。这个操作句柄保存在instance(OmxNodeInstance类型)对象中，与之对应的是一个node id，是一个32位的无符号int值，两者以键值对形式存放在mNodeIDToInstance变量中。acodec可以拿到的就是这个node id和omx bp代理对象。
