package util.json;

/**
 * Created by pengsel on 2019/4/8.
 */

import java.text.SimpleDateFormat;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import java.util.*;

/**
 * Created by geely
 */

public class JsonUtil {


    private static ObjectMapper objectMapper = new ObjectMapper();
    static{
        //对象的所有字段全部列入
        objectMapper.setSerializationInclusion(Inclusion.ALWAYS);

        //取消默认转换timestamps形式
        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,false);

        //忽略空Bean转json的错误
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);

        //所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        //忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }



    public static <T> String obj2String(T obj){
        if(obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String)obj :  objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
//            log.warn("Parse Object to String error",e);
            return null;
        }
    }

    public static <T> String obj2StringPretty(T obj){
        if(obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String)obj :  objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
//            log.warn("Parse Object to String error",e);
            return null;
        }
    }





    public static <T> T string2Obj(String str,Class<T> clazz){
        if(StringUtils.isEmpty(str) || clazz == null){
            return null;
        }

        try {
            return clazz.equals(String.class)? (T)str : objectMapper.readValue(str,clazz);
        } catch (Exception e) {
//            log.warn("Parse String to Object error",e);
            return null;
        }
    }



    public static <T> T string2Obj(String str, TypeReference<T> typeReference){
        if(StringUtils.isEmpty(str) || typeReference == null){
            return null;
        }
        try {
            return (T)(typeReference.getType().equals(String.class)? str : objectMapper.readValue(str,typeReference));
        } catch (Exception e) {
//            log.warn("Parse String to Object error",e);
            return null;
        }
    }


    public static <T> T string2Obj(String str,Class<?> collectionClass,Class<?>... elementClasses){
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass,elementClasses);
        try {
            return objectMapper.readValue(str,javaType);
        } catch (Exception e) {
//            log.warn("Parse String to Object error",e);
            return null;
        }
    }




    static class Person{
        private String name;
        private int age;
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }


    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("Tom");
        person1.setAge(18);
        person1.setSex("male");

        //注意对象中不能有构造器
        //对象转Json
        String str = JsonUtil.obj2String(person1);
        System.out.println(str);
        //对象转成prettyjson
        String strPretty = JsonUtil.obj2StringPretty(person1);
        System.out.println(strPretty);
        //json转成对象
        String json = "{\"name\":\"Geely\",\"age\":19,\"sex\":\"female\"}";
        Person person2 = JsonUtil.string2Obj(json, Person.class);

        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        //List对象转成json
        String listString = JsonUtil.obj2StringPretty(list);
        System.out.println(listString);
        //json转成List对象
        List<Person> listFromJson = JsonUtil.string2Obj(listString, List.class, Person.class);
    }
}
