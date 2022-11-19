import sys, heapq


def main():
    count = int(input())
    lessons = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(count)]
    lessons.sort()

    class_rooms = [lessons[0][1]]

    for i in range(1, count):
        if class_rooms[0] <= lessons[i][0]:
            heapq.heappop(class_rooms)
            heapq.heappush(class_rooms, lessons[i][1])
        else:
            heapq.heappush(class_rooms, lessons[i][1])

    print(len(class_rooms))


if __name__ == "__main__":
    main()