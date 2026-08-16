package Greed;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
	public static void printMaxActivities(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end)); // 按结束时间排序
        int count = 1; // 至少可以选择第一个活动
        int endTime = activities[0].end; // 选择第一个活动的结束时间作为参考点
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= endTime) { // 如果当前活动的开始时间大于等于上一个选择的活动的结束时间，则选择该活动
                count++; // 更新活动计数
                endTime = activities[i].end; // 更新结束时间参考点
            }
        }
        System.out.println("Maximum activities that can be selected: " + count); // 输出可选择的活动的最大数量
    }

    public static void main(String[] args) {
        Activity[] activities = {new Activity(1, 3), new Activity(3, 4), new Activity(0, 6), new Activity(5, 7), new Activity(8, 9), new Activity(5, 9)};
        printMaxActivities(activities); // 输出: Maximum activities that can be selected: 4 (选择活动: [0,6], [5,7], [8,9])
    }
}
class Activity {
    int start, end;
    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
