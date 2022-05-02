# Generates our x and y values then plots them for our original linear graph and calls it 'linear graph' then it calls salter
function plotter()
 y = []
 x = []
 for i = 1:100
  newElem = i + 1
  x = [x newElem]
endfor
disp(x)
for i = 1:length(x)
  newElem = 2*(i)+ 3
  y = [y newElem]
end
subplot(2,2,1)
plot(x,y,"r");
title('linear graph')
hold on
disp(x)
disp(y)
salter(x,y)
endfunction
#Salting function which generates random ints ar in interval of 1-10 and adds then subtracts to every y val in the y vector to salt the graph then plots the salted graph and calls "smoother"
function salter(x,y)
counter = 1
for i = 1:length(x)
ri = randi(10,1)
if(mod(counter,2) == 1)
y(i) = y(i) + ri
else
y(i) = y(i) - ri
endif
counter++
end
disp(y)
subplot(2,2,2)
plot(x,y,"g");
title('Salted Linear Graph')
smoother(x,y)
endfunction
#Smoothing function which computes the rolling average of 3 numbers then adds that to the yval list and the plots the smoothed grpah
function smoother(x,y)

s = []
for i = 1:length(x) - 2
newval = (y(i) + y(i + 1) + y(i + 2))/3
s = [s newval]
endfor
x(end)=[];
x(end)=[];
disp(s)
subplot(2,2,3)
plot(x,s)
title('Smoothed Graph')
endfunction

