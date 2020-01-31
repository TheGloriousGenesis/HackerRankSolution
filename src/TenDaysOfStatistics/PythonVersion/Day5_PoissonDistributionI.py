import math


def negative_binomial_distribution(n, x, p):
    # constant = Tools.unordered_permutations(n - 1, x - 1)
    constant = math.factorial(n-1) / (math.factorial((n-1) - (x-1)) * math.factorial(x-1))
    return constant * pow(p, x) * pow((1 - p), (n - x))


def geometric_distribution(arr, n):
    p = arr[0]/arr[1]
    x = 1
    return negative_binomial_distribution(n, x, p)


def poisson(lamda, k):
    # lamda average number of successes that occur in specified region
    # k actual number of successes that occur in a specified region
    # probability of success is proportional to the size of the region
    # average number of success (lamda) occuring in specified region is known
    return (pow(lamda, k) * math.exp(-lamda)) / math.factorial(k)


def expectation_squared(lamda):
    return lamda + pow(lamda, 2)


if __name__ == '__main__':
    lamda = int(input())
    k = int(input())
    value = "{:.3f}"
    x = poisson(lamda, k)
    print(value.format(x))

    x2 = 0
    for i in range(0, 4):
        x2 += poisson(lamda, i)

    print(value.format(x2))





