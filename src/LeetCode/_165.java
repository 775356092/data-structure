package LeetCode;

/**
 * @description: 比较版本号
 * @author: wang hao
 * @create: 2020-10-29 09:28
 */
public class _165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i, j;
        for (int k = 0; k < Math.max(v1.length, v2.length); k++) {
            i = k < v1.length ? Integer.parseInt(v1[k]) : 0;
            j = k < v2.length ? Integer.parseInt(v2[k]) : 0;
            if (i != j) {
                return i > j ? 1 : -1;
            }
        }
        return 0;
    }
}
