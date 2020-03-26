//package com.alibaba.csp.sentinel.dashboard.config;
//
//import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
//import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
//import com.alibaba.csp.sentinel.datasource.Converter;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
///**
// * @author cdfive
// */
//@Configuration
//public class RuleConverterConfig {
//
//    @Bean
//    public <T> Converter<List<T>, String> ruleEntityEncoder() {
//        return JSON::toJSONString;
//    }
//
//    @Bean
//    public <T> Converter<String, List<T>> ruleEntityDecoder() {
////        return s -> JSON.parseArray(s, T);
//        return s -> JSON.parseObject(s, new TypeReference<List<T>>(){});
//    }
//
////    @Bean("flowRuleEntityEncoder")
////    public Converter<List<FlowRuleEntity>, String> flowRuleEntityEncoder() {
////        return JSON::toJSONString;
////    }
////
////    @Bean("flowRuleEntityDecoder")
////    public Converter<String, List<FlowRuleEntity>> flowRuleEntityDecoder() {
////        return s -> JSON.parseArray(s, FlowRuleEntity.class);
////    }
//
////    @Bean("degradeRuleEntityDecoder")
////    public Converter<String, List<DegradeRuleEntity>> degradeRuleEntityDecoder() {
////        return s -> JSON.parseArray(s, DegradeRuleEntity.class);
////    }
//
//    public static void main(String[] args) {
//        // ResolvableType.forClass(converter.getClass()).resolve().getSimpleName()
//        String json = "[{\"app\":\"sentinel-dashboard\",\"clusterMode\":false,\"controlBehavior\":0,\"count\":20.0,\"gmtCreate\":1585199950870,\"gmtModified\":1585199950870,\"grade\":1,\"id\":1,\"limitApp\":\"default\",\"resource\":\"aa\",\"strategy\":0}]";
//
//        List<FlowRuleEntity> flowRuleEntities = JSON.parseObject(json, new TypeReference<List<FlowRuleEntity>>() {
//        });
//        System.out.println(flowRuleEntities);
//
//        List<?> objects = JSON.parseObject(json, new TypeReference<List<?>>() {
//
//        });
//        System.out.println(objects);
//    }
//}
