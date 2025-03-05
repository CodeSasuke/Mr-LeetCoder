import java.util.Arrays;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int i = -1; // Slow pointer to store the final valid asteroids

        for (int asteroid : asteroids) {
            boolean isDestroyed = false;

            // Process collisions
            while (i >= 0 && asteroids[i] > 0 && asteroid < 0) {
                if (asteroids[i] == -asteroid) {  // Equal size: both explode
                    i--;
                    isDestroyed = true;
                    break;
                } else if (asteroids[i] > -asteroid) { // Stack top is bigger, new asteroid explodes
                    isDestroyed = true;
                    break;
                } else {  // Stack top is smaller, pop it and continue checking
                    i--;
                }
            }

            // If asteroid is not destroyed, add it to the final array
            if (!isDestroyed) {
                asteroids[++i] = asteroid;
            }
        }

        // Create result array with valid asteroids
        return Arrays.copyOf(asteroids, i + 1);
    }
}
