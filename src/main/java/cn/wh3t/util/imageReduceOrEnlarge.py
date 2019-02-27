#-*- coding: UTF-8 -*-   

from PIL import Image  

#读取图像  
im = Image.open("G:\StudyTest\Toutiao\src\main\webapp\images\img\downloadImages\1.jpg")  
im.show()  

#原图像缩放为128x128  
im_resized = im.resize((128, 128))  
im_resized.show()
