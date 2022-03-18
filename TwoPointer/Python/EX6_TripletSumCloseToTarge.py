# Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the
# target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum
# of the triplet with the smallest sum.
#
# Example 1:
#
# Input: [-2, 0, 1, 2], target=2
# Output: 1
# Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
# Example 2:
#
# Input: [-3, -1, 1, 2], target=1
# Output: 0
# Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
# Example 3:
#
# Input: [1, 0, 1, 1], target=100
# Output: 3
# Explanation: The triplet [1, 1, 1] has the closest sum to the target.

def searchTriplets(arr, target):
    arr = sorted(arr)
    ans = float('inf')
    for i in range(len(arr)):
        l = i + 1
        r = len(arr) - 1
        while l < r:
            curr_sum = arr[l] + arr[r] + (arr[i])
            if curr_sum < target:
                if abs(target - ans) >= target - curr_sum:
                    ans = curr_sum
                l += 1
            elif curr_sum > target:
                if abs(target - curr_sum) > abs(target - curr_sum):
                    ans = curr_sum
                r -= 1
            else:
                return target

    return ans


# Author solution
# def triplet_sum_close_to_target(arr, target_sum):
#   arr.sort()
#   smallest_difference = math.inf
#   for i in range(len(arr)-2):
#     left = i + 1
#     right = len(arr) - 1
#     while (left < right):
#       target_diff = target_sum - arr[i] - arr[left] - arr[right]
#       if target_diff == 0:  # we've found a triplet with an exact sum
#         return target_sum  # return sum of all the numbers
#
#       # the second part of the following 'if' is to handle the smallest sum when we have
#       # more than one solution
#       if abs(target_diff) < abs(smallest_difference) or
#                        (abs(target_diff) == abs(smallest_difference) and
#                                            target_diff > smallest_difference):
#         smallest_difference = target_diff  # save the closest and the biggest difference
#
#       if target_diff > 0:
#         left += 1  # we need a triplet with a bigger sum
#       else:
#         right -= 1  # we need a triplet with a smaller sum
#
#   return target_sum - smallest_difference

def main():
    print(searchTriplets([-2, 0, 1, 2], 2))
    print(searchTriplets([-3, -1, 1, 2], 1))
    print(searchTriplets([1, 0, 1, 1], 100))


main()