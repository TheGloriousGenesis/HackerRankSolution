class Tools:

    def fraction_simplifier(self, x1, x2):
        gcf = self.greatest_common_factor(x1, x2)
        x2 //= gcf
        x1 //= gcf
        return x1, x2

    # Euclid's Algorithm
    def greatest_common_factor(self, y1, y2):
        values = [y1, y2]
        values.sort()
        lowest_number = values[1] - values[0]
        if lowest_number != 0:
            return self.greatest_common_factor(lowest_number, values[0])
        return values[0]

    @staticmethod
    def simple_bayes_theorem(p_ab, p_a):
        return p_ab / p_a

    @staticmethod
    def bayes_theorem(p_a, p_ba, p_bac, p_ac):
        # P(A|B) = (P(B|A) * P(A))/(P(B|A) * P(A) + P(B|Ac) * P(Ac))
        return (p_ba * p_a)/((p_ba * p_a) + (p_bac * p_ac))

    @staticmethod
    def ordered_permutations(n, r):
        n_factorial = Tools.factorial(n)
        n_r_factorial = Tools.factorial(n - r)
        return n_factorial / n_r_factorial

    # An unordered arrangement of r objects from a set A of n object where r <= n
    # a way of organising n objects in r ways where the r ways DOES NOT matter
    @staticmethod
    def unordered_permutations(n, r):
        n_factorial = Tools.factorial(n)
        n_r_factorial = Tools.factorial(n - r)
        r_factorial = Tools.factorial(r)
        return n_factorial / (n_r_factorial * r_factorial)

    # factorial
    @staticmethod
    def factorial(x):
        n = x - 1
        if x == 0:
            return 1
        if n > 1:
            return Tools.factorial(n) * x
        else:
            return x


if __name__ == '__main__':
    top = int(input())
    bottom = int(input())
    s = Tools()
    f = s.fraction_simplifier(top, bottom)
    value = "{}/{}"
    print(value.format(f[0], f[1]))
