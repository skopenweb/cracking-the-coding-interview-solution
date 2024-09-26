package misc;

class ShortestWordEditPathSolution {
    static int shortestWordEditPath(String source, String target, String[] words) {
        boolean[] v = new boolean[words.length];

        int[] min = {Integer.MAX_VALUE};

        for (int i = 0; i < words.length; i++) {
            if (isNext(source, words[i])) {
                find(i, 1, words[i], target, words, v, min);
            }
        }
        return min[0] == Integer.MAX_VALUE ? -1 : min[0];
    }

    static void find(int j, int level, String curr, String target, String[] words, boolean[] v, int[] min) {
        if (level > min[0]) return;
        if (curr.equals(target)) {
            min[0] = level;
            return;
        }
        v[j] = true;
        for (int i = 0; i < words.length; i++) {
            if (!v[i] && isNext(curr, words[i])) {
                find(i, level + 1, words[i], target, words, v, min);
            }
        }
        v[j] = false;
    }

    public static void main(String[] args) {
    }

    static boolean isNext(String w1, String w2) {
        int c = 0;
        for (int i = 0; i < w1.length() && i < w2.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) c++;
        }
        return c == 1;
    }
}