import java.util.Arrays;

/**
 * @program: AlgorithmProject.PACKAGE_NAME.PriorityQueue
 * @description: 优先队列
 * @author: Ruipeng
 * @create: 2020/6/4 2:02
 */
public class PriorityQueue {
    private int[] array;
    private int size = 0;

    public PriorityQueue() {
        array = new int[32];
    }

    public int[] getArray() {
        return array;
    }

    /**
     * @Description: 入队
     * @Param: [value]
     * @return: void
     * @Author: Ruipeng
     */
    public void enQueue(int value) {
        if (size >= array.length) {
            resize();
        }
        array[size++] = value;
        upAdjust();
    }

    /**
     * @Description: 出队
     * @Param: []
     * @return: java.lang.Integer
     * @Author: Ruipeng
     */
    public Integer deQueue() throws Exception {
        if (size <= 0) {
            throw new Exception("the Queue is empty");
        }
        int head = array[0];
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * @Description: 上浮调整
     * @Param: []
     * @return: void
     * @Author: Ruipeng
     */
    public void upAdjust() {
//        最后一个子节点
        int nodeIndex = size - 1;
//        父节点
        int parentIndex = (nodeIndex - 1) / 2;
//        临时节点,保存上浮节点
        int tempNode = array[nodeIndex];
//        与父节点比较
        while (nodeIndex > 0 && tempNode > array[parentIndex]) {
            array[nodeIndex] = array[parentIndex];
            nodeIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[nodeIndex] = tempNode;
    }

    /**
     * @Description: 下沉调整
     * @Param: []
     * @return: void
     * @Author: Ruipeng
     */
    public void downAdjust() {
        int parentIndex = 0;
        int tempNode = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            if ((childIndex + 1 < size && array[childIndex + 1] > array[childIndex])) {
                childIndex++;
            }
            if (tempNode >= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        array[parentIndex] = tempNode;
    }

    /**
     * @Description: 数组扩容
     * @Param: []
     * @return: void
     * @Author: Ruipeng
     */
    public void resize() {
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue queue = new PriorityQueue();
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(10);
        queue.enQueue(2);
        queue.enQueue(7);
        System.out.println("出队元素：" + queue.deQueue());
        System.out.println("出队元素：" + queue.deQueue());
    }
}
