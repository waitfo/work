import com.demo.cn.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void testAdd(){
        //1.加载spring配置文件
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("bean1.xml");

        //2.获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @org.junit.Test
    public void test(){
        int[] ints = {1,4,3,2};
        quicksort(ints,0,ints.length-1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    public void quicksort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int i=left;
        int j=right;
        int m=nums[i];

        while (i<j){
            while(i<j && m<=nums[j]){//从右边找小于m的值，
                j--;
            }
            if(i<j&&m>nums[j]){
                nums[i]=nums[j];
            }
            while (i<j && m>=nums[i]){//从左边找大于m的值
                i++;
            }
            if(i<j&&m<nums[i]){
                nums[j]=nums[i];
            }
        }
        nums[i]=m;
        if(left<i-1){
            quicksort(nums,left,i-1);
        }
        if(right>i+1)
            quicksort(nums,i+1,right);

    }
}
