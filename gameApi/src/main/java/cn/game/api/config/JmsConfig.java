package cn.game.api.config;


// 参考http://www.jianshu.com/p/d8d73c872665
//http://elim.iteye.com/blog/1900937

//@Configuration
//@EnableJms
public class JmsConfig {
//	// topic模式的ListenerContainer
//    @Bean
//    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
//        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
//        bean.setPubSubDomain(true);
//        bean.setConnectionFactory(activeMQConnectionFactory);
//        //bean.setMessageConverter(jacksonJmsMessageConverter());
//        return bean;
//    }
//    // queue模式的ListenerContainer
//    @Bean
//    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory) {
//        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
//        bean.setConnectionFactory(activeMQConnectionFactory);
//        bean.setMessageConverter(jacksonJmsMessageConverter());
//        return bean;
//    }
//
//
//	/**
//     * 消息转换器
//     * @return
//     */
//	@Bean
//    public MessageConverter jacksonJmsMessageConverter() {
//        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//        converter.setTargetType(MessageType.TEXT);
//        converter.setTypeIdPropertyName("_type");
//        return converter;
//    }


}
