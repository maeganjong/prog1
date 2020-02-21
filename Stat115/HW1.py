def solution():
    buff = [-2, 1, 7, -4, 5, 2, -3, -6, 4, 3, -8, -1, 6, -7, -9, -5]
    sum = buff[0]
    general = buff[0]
    i = 1
    while i < len(buff):
    sum = max(sum + buff[i], buff[i]) 
    Z = max(Z, sum)
    return Z
