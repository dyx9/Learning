package medium;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {

        int volume = 0;
        int left = 0;
        int right = height.length-1;

        while (left < right) {
            int current = Math.min(height[left], height[right]) * (right-left);
            volume = Math.max(volume, current);

            // move the pointer that has a lower height
            if (height[right] < height[left]) {
                right--;
            }
            else {
                left++;
            }
        }
        return volume;
    }

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
