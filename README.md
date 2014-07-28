#开发说明

##安装说明

    下载：git clone https://github.com/cncduLee/alarm.git
    构建eclipse工程:  mvn eclipse:eclipse
    构建idea工程:     mvn idea:idea
    
    
##使用说明

    命令行：mvn clean test

##项目结构
	
	alarm/
		* code          通用的基础实体
		* service  		对外接口
		* mq            自定义的消息中间件
		* send          消息发送处理
		* third         依赖接入【解决耦合】
		* test          测试
		
## 依赖包
    
    Spring-core
    Spring-bean
    Spring-context
    Spring-test
    junit
    slf4j
    
##扩展说明

###如:添加微信发送方式：
    1：对外部以来的扩展方式进行适配,做法是:在emit(发送器)部分添加适配WxSender.java
        @Service("smsSender")
	public class SmsSender implements Sender {
	    @Override
	    public void send(String content, String calling) {
	        SmsUtils.getInstance().sendMessage(content, calling);
	    }
	}
    2: 定义优先级规则以及消息类型：如短信，
       public class SmsType extends MessageType{
	
	    public SmsType() {
	        super();
	    }
	
	    @Override
	    public String setName() {
	        return "sms";
	    }
	
	    @Override
	    public int setPriority() {
	        return -1;
	    }
	}
       
##设计思路
   
   ![DataV logo](https://raw.github.com/cncduLee/alarm-platform/master/work.png)    

##说明
    
    1：由于时间仓促，还没怎么测试，所以测试覆盖率不高。这个写的太累赘了，应该在明天会放一个小巧的版本
    2：推荐看我以前写的这个p-c代码(有rpc的东西在里面)：https://github.com/cncduLee/asynchronous/
     
