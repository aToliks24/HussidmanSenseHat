import multiprocessing
from sys import stdin
from threading import Timer
from multiprocessing import Value,Process
from gi.overrides.keysyms import target

kill = lambda p: p.terminate()

def myfunc(res):
    res.put( input(''))

q=multiprocessing.Manager().Queue()
p=Process(target=myfunc,args=(q,))
#my_timer = Timer(5, p.terminate)5

try:
    
    #my_timer.start()
    p.start()
    p.join
    r=q.get()
finally:
    my_timer.cancel()
    
    
print('stdout:'+str(stdin))