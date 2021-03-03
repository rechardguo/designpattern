package rechard.learn.eshop.auth.service;

import rechard.learn.eshop.auth.domain.Priority;

/**
 * visitor 类
 * 泛型表示处理的结果
 */
public interface PriorityOperation<T> {
   /**
    * 处理priority
    * @param priority
    */
   T execute(Priority priority);
}
