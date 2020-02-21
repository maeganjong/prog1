import time
start_time = time.time()

def fib1(num):
    if num <= 1:
        return num
    return fib1(num - 1) + fib1(num - 2) 

def fib2(num):
    if num <= 1:
        return num
    
    result = 0
    back1 = 0
    back2 = 1

    for i in range(2, num+1):
        result = back1 + back2
        back2 = back1
        back1 = result
    
    result = back1 + back2
    return result

def fib3(num): 
    if num <= 1:
        return num
    mat = [[0, 1], [1, 1]]
    helper_3(mat, num)
    return mat[0][1] 

def helper_3(mat, exp): 
    if exp <= 1: 
        return;  

    helper_3(mat, exp / 2) 

    # multiply mat with mat
    a = (mat[0][1] * mat[1][0] + 
         mat[0][0] * mat[0][0])
    b = (mat[1][0] * mat[0][0] + 
         mat[1][1] * mat[1][0]) 
    c = (mat[0][1] * mat[1][1] +
        mat[0][0] * mat[0][1]) 
    d = (mat[1][0] * mat[0][1] + 
         mat[1][1] * mat[1][1])
       
    mat[0][0] = a 
    mat[1][0] = b 
    mat[0][1] = c 
    mat[1][1] = d  

    if (exp % 2 == 1): 
        buffer = [[0, 1], [1, 1]]
        a = (mat[0][1] * buffer[1][0] + 
            mat[0][0] * buffer[0][0])
        b = (mat[1][0] * buffer[0][0] + 
            mat[1][1] * buffer[1][0]) 
        c = (mat[0][1] * buffer[1][1] +
            mat[0][0] * buffer[0][1]) 
        d = (mat[1][0] * buffer[0][1] + 
            mat[1][1] * buffer[1][1])
        
        mat[0][0] = a 
        mat[1][0] = b 
        mat[0][1] = c 
        mat[1][1] = d  


## Avoiding overflow with modulo

def fib1_mod(num):
    if num <= 1:
        return num
    return (fib1(num - 1) % 65536 + fib1(num - 2) % 65536) % 65536

def fib2_mod(num):
    if num <= 1:
        return num
    
    result = 0
    back1 = 0
    back2 = 1

    for i in range(2, num+1):
        result = (back1 + back2) % 65536
        back2 = back1
        back1 = result

    result = (back1 + back2) % 65536

    return result

def fib3_mod(num): 
    if num <= 1:
        return num
    mat = [[0, 1], [1, 1]]
    helper_3_mod(mat, num)
    return (mat[0][1])

def helper_3_mod(mat, exp): 
    if exp <= 1: 
        return;  

    helper_3_mod(mat, exp / 2) 

    a = (((mat[0][1] * mat[1][0]) % 65536) + 
         ((mat[0][0] * mat[0][0]) % 65536))
    b = (((mat[1][0] * mat[0][0]) % 65536) + 
         ((mat[1][1] * mat[1][0]) % 65536)) 
    c = (((mat[0][1] * mat[1][1]) % 65536) +
        ((mat[0][0] * mat[0][1]) % 65536)) 
    d = (((mat[1][0] * mat[0][1]) % 65536) + 
         ((mat[1][1] * mat[1][1])) % 65536)
       
    mat[0][0] = a 
    mat[1][0] = b 
    mat[0][1] = c 
    mat[1][1] = d  

    if (exp % 2 == 1): 
        buffer = [[0, 1], [1, 1]]
        a = (((mat[0][1] * mat[1][0]) % 65536) + 
         ((buffer[0][0] * buffer[0][0]) % 65536))
        b = (((mat[1][0] * mat[0][0]) % 65536) + 
         ((buffer[1][1] * buffer[1][0]) % 65536)) 
        c = ((mat[0][1] * mat[1][1]) % 65536 +
        (buffer[0][0] * buffer[0][1]) % 65536)
        d = (((mat[1][0] * mat[0][1]) % 65536) + 
         ((buffer[1][1] * buffer[1][1])) % 65536)
        
        mat[0][0] = a 
        mat[1][0] = b 
        mat[0][1] = c 
        mat[1][1] = d  

# print("--- %s seconds ---" % (time.time() - start_time))

n = 4518272000
fib3_mod(n)
while (time.time() - start_time) < 10:
    start_time = time.time()
    n += 1
    fib3_mod(n)
    print(n)
    
    
print(n)



