#-*- coding: UTF-8 -*-   

from PIL import Image  

#读取图像  
im = Image.open("1.png")  
#im.show()

#原图像缩放为128x128  
im_resized = im.resize((128, 128))  
#im_resized.show()
im_resized.save('img_1.png')
