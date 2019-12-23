def mean(numbers):
    sum = 0
    for i in numbers:
        sum = sum + i
    return sum / len(numbers)


def mode(numbers):
    occurrences = {x: 0 for x in numbers}
    for x in range(len(numbers)):
        if numbers[x] in occurrences:
            occurrences[numbers[x]] = occurrences[numbers[x]] + 1

    maxValueOccurence = 0
    maxValue = []

    for i, j in occurrences.items():
        if (j >= maxValueOccurence):
            maxValueOccurence = j
            maxValue.append(i)
    return min(maxValue)


def median(numbers):
    return 0

def start():
    global n
    n = input("Number of elements in array: ")
    elements = input("Space seperated numerical list: ")
    split = list(map(int, (val for val in elements.split() if val.isdigit())))
    return split

if __name__ == '__main__':
    x = start()



    print("Mean")
    print(mean(x))
    print("Mode")
    print(mode(x))
    print("Median")
    print(median(x))
