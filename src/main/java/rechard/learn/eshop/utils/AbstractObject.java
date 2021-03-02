package rechard.learn.eshop.utils;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 克隆
 */
public class AbstractObject {

    /**
     * 正向克隆
     */
    public static Integer DIRECTION_FORWARD=1;
    /**
     * 反向克隆
     */
    public static Integer DIRECTION_BACKWARD=2;
    /**
     * 浅克隆
     * @param t 目标对象
     * @param <T> 目标对象Class
     */
    public<T> void clone(T t){
        BeanCopierUtils.copy(this,t);
    }
    /**
     * 浅克隆
     * @param t 目标对象
     * @param <T> 目标对象Class
     */
    public<T> void clone(Class<T> t) throws Exception {
        T target=t.newInstance();
        BeanCopierUtils.copy(this,target);
    }

    public<T> void clone(T t,int direction) throws Exception{
        //浅克隆完成
        BeanCopierUtils.copy(this,t);
        //完成对source对象里的list的拷贝
        Class targetCl=t.getClass();
        Field[] fields=this.getClass().getDeclaredFields();
        for (Field field:fields){
            field.setAccessible(true);

            Class type=field.getType();
            if( type == List.class){
                //获取list的泛型对象
                Class sourceGenericCl=getGenericClass(field);
                if (sourceGenericCl==null){
                    System.out.println("warn: skip field please set generic type for field"+field.getName());
                    continue;
                }
                //通过克隆方向和genericClType来获取target类里的list的泛型class
                Class targetGenericCl=getTargetListFieldGenericClass(sourceGenericCl,direction);

                List sourceList = (List) field.get(this);
                if(sourceList==null)
                    continue;

                List targetList = new ArrayList();
                //list里有可能也有同样的需要拷贝的类型
                cloneList(sourceList,targetList,targetGenericCl,direction);

                Field targetField=getTargetFiled(t,targetGenericCl);
                if(targetField!=null)
                    targetField.set(t,targetList);
            }
        }
    }

    /**
     * 根据targetGenericCl来变量T 获取到是否有List<targetGenericCl>的field
     * @param targetGenericCl
     * @param t
     * @param <T>
     * @return
     */
    private <T> Field getTargetFiled(T t,Class targetGenericCl) {
        Class cl=t.getClass();
        Field[] fields=cl.getDeclaredFields();
        for(Field fl:fields){
            //如果类里的field是list类型，则需判断泛型是否是targetGenericCl
            if(fl.getType()==List.class){
                if(getGenericClass(fl)==targetGenericCl){
                    fl.setAccessible(true);
                    return fl;
                }
            }
        }
        return null;
    }

    /**
     * 克隆list到list
     * @param sourceList
     * @param targetList
     * @param targetGenericCl
     * @param direction
     * @throws Exception
     */
    private void cloneList(List<AbstractObject> sourceList,
                           List<AbstractObject> targetList,
                           Class<?extends AbstractObject> targetGenericCl,
                           int direction) throws Exception {
        for(AbstractObject s:sourceList){
            AbstractObject target=targetGenericCl.newInstance();
            s.clone(target,direction);
            targetList.add(target);
        }
    }
    /**
     * 业务逻辑是
     * 如果direction是正向
     * genericClType类名后2位从 VO -> DTO 或 DTO->DO
     *
     * 如果是反向则反过来
     *
     * @param genericClType
     * @param direction
     * @return
     */
    private Class getTargetListFieldGenericClass(Class genericClType, int direction)
            throws ClassNotFoundException {
        String  targetClName="";
        String clName=genericClType.getName();
        if(direction==DIRECTION_FORWARD){
            if(clName.endsWith("VO")) {
                targetClName=clName.substring(0,clName.length()-2)+"DTO";
            }else if(clName.endsWith("DTO")){
                targetClName=clName.substring(0,clName.length()-3)+"DO";
            }
        }else{
            if(clName.endsWith("DO")) {
                targetClName=clName.substring(0,clName.length()-2)+"DTO";
            }else if(clName.endsWith("DTO")){
                targetClName=clName.substring(0,clName.length()-3)+"VO";
            }
        }
        if(!targetClName.equals("")){
            return Class.forName(targetClName);
        }
        return null;
    }

    private Class<?> getGenericClass(Field field) {
        Type genericType=field.getGenericType();
        if(genericType instanceof ParameterizedTypeImpl){
            Type[] types=((ParameterizedTypeImpl) genericType).getActualTypeArguments();
            return (Class<?>) types[0];
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        CategoryDO root=new CategoryDO();
        root.setId(1);
        root.setCode("root");
        root.setUrl("root");

        CategoryDO rch1=new CategoryDO();
        rch1.setId(2);
        rch1.setCode("root-ch1");
        rch1.setUrl("root-ch1");


        CategoryDO rch2=new CategoryDO();
        rch1.setId(3);
        rch1.setCode("root-ch2");
        rch1.setUrl("root-ch2");

        List list=new ArrayList();
        list.add(rch1);
        list.add(rch2);
        root.setChildren(list);

        CategoryDTO categoryDTO=new CategoryDTO();
        root.clone(categoryDTO,AbstractObject.DIRECTION_BACKWARD);
        System.out.println(categoryDTO);
    }
}
