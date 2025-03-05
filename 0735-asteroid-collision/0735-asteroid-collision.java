import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!list.isEmpty() && list.get(list.size() - 1) > 0 && asteroid < 0) {
                int top = list.get(list.size() - 1);
                int absAsteroid = Math.abs(asteroid);
                int absTop = Math.abs(top);

                if (absAsteroid > absTop) {
                    list.remove(list.size() - 1); // Destroy the top asteroid and continue checking
                } else if (absAsteroid == absTop) {
                    list.remove(list.size() - 1); // Both asteroids destroy each other
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                list.add(asteroid);
            }
        }

        // Convert list to array
        return list.stream().mapToInt(i -> i).toArray();
    }
}
