import math
from Tools.Tools import Tools


def negative_binomial_distribution(n, x, p):
    # constant = Tools.unordered_permutations(n - 1, x - 1)
    constant = math.factorial(n-1) / (math.factorial((n-1) - (x-1)) * math.factorial(x-1))
    return constant * pow(p, x) * pow((1 - p), (n - x))


def geometric_distribution(arr, n):
    p = arr[0]/arr[1]
    x = 1
    return negative_binomial_distribution(n, x, p)


if __name__ == '__main__':
    x1 = [int(i) for i in input().strip().split(' ')]
    x2 = int(input())
    value = "{:.3f}"
    cum = 0
    # print(value.format(geometric_distribution(x1, x2)))
    for i in range(1, 6, 1):
        cum += geometric_distribution(x1, i)
    print(value.format(cum))
