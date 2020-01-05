from Tools.Tools import Tools


class Permutations:
    # An orderded arrangement of r objects from a set A of n objects where 0 < r <= n
    # a way of organising n objects in r ways where the r ways DOES matter
    @staticmethod
    def ordered_permutations(n, r):
        n_factorial = Permutations.factorial(n)
        n_r_factorial = Permutations.factorial(n - r)
        return n_factorial / n_r_factorial

    # An unordered arrangement of r objects from a set A of n object where r <= n
    # a way of organising n objects in r ways where the r ways DOES NOT matter
    @staticmethod
    def unordered_permutations(n, r):
        n_factorial = Permutations.factorial(n)
        n_r_factorial = Permutations.factorial(n - r)
        r_factorial = Permutations.factorial(r)
        return n_factorial / (n_r_factorial * r_factorial)

    # factorial
    @staticmethod
    def factorial(x):
        n = x - 1
        if x == 0:
            return 1
        if n > 0:
            return Permutations.factorial(n) * x
        else:
            return 1


if __name__ == '__main__':
    value = "{}/{}"
    x = int(Permutations.unordered_permutations(4, 1) * Permutations.unordered_permutations(13, 2))
    y = int(Permutations.unordered_permutations(52, 2))
    s = Tools()
    f = s.fraction_simplifier(x, y)
    print(value.format(f[0], f[1]))
