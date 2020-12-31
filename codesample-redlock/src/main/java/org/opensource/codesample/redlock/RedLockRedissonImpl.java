package org.opensource.codesample.redlock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**
 * The class RedLockRedissonImpl
 * <p>
 * RedLock原理:
 * <ul>
 *     <li>1 得到本地时间</li>
 *     <li>2 Client使用相同的key和随机数,按照顺序在每个Master实例中尝试获得锁。在获得锁的过程中，为每一个锁操作设置一个快速失败时间
 *     (如果想要获得一个10秒的锁， 那么每一个锁操作的失败时间设为5-50ms)。这样可以避免客户端与一个已经故障的Master通信占用太长时间，
 *     通过快速失败的方式尽快的与集群中的其他节点完成锁操作。客户端计算出与master获得锁操作过程中消耗的时间，
 *     当且仅当Client获得锁消耗的时间小于锁的存活时间，并且在一半以上的master节点中获得锁。才认为client成功的获得了锁</li>
 *     <li>3 如果已经获得了锁，Client执行任务的时间窗口是锁的存活时间减去获得锁消耗的时间。</li>
 *     <li>4 如果Client获得锁的数量不足一半以上，或获得锁的时间超时，那么认为获得锁失败。客户端需要尝试在所有的master节点中释放锁，
 *     即使在第二步中没有成功获得该Master节点中的锁，仍要进行释放操作。。</li>
 * </ul>
 *
 * @see java.util.concurrent.locks.Lock
 *
 * @see String
 */
public class RedLockRedissonImpl {

    public RedLockRedissonImpl() {
        RedissonClient client = Redisson.create();

        RLock lock = client.getLock("");
    }
}
