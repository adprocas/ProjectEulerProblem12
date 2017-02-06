package projecteulerproblem12;

public class ProjectEulerProblem12 {

    public static void main(String[] args) {
        long i = 2L;
        long triangleNumber = 1L;
        long limit = 500L * 500L;

        while (true) {
            /**
             * no need to test anything that isn't divisible by 2 or 3. I don't
             * know if it is certain, but it's very unlikely that the number
             * will not be divisible by 2 and 3. Being divisible by 2 increases
             * the potential number of factors (all even numbers) the same can
             * be said for 3 (every third number)
             */
            if (triangleNumber >= limit && triangleNumber % 2 == 0 && triangleNumber % 3 == 0) {
                int factors = countFactors(triangleNumber);
                if (factors >= 500) {
                    System.out.println(triangleNumber);

                    break;
                }
            }

            triangleNumber += i;
            ++i;
        }
    }

    public static int countFactors(long number) {
        int numberOfFactors = 0;
        long upperLimit = (long) Math.ceil(Math.sqrt(number));

        if (number % upperLimit == 0) {
            numberOfFactors = 1;
        }
        /**
         * think about doing this so you only need to go up to the square reason
         * - to find factors of 25, for example 1 and 25 5 and 25
         *
         * no need to check anything over 5 (5 is sqrt(25)), because we know
         * there are two for every possible combination below, which will cover
         * all of the options above
         *
         * for example, 81
         *
         * 1 - 81, 3 - 27, 9 - 9
         *
         * so, do the sqrt, find if it is a factor. If so, add 1 to total
         * factors and continue. If not, find the ceil and work up until that
         * number. All factors have two factors, so add for each found up until
         * sqrt
         */
        for (int x = 1; x <= upperLimit; ++x) {
            if (number % 2 != 0 && x % 2 == 0) {
                ++x;

                if (x > number) {
                    break;
                }
            }

            if (number % x == 0) {
                numberOfFactors += 2;
            }
        }

        return numberOfFactors;
    }
}
