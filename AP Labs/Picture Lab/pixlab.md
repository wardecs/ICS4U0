### Pixlab Answers

### A1

1. How many bits does it take to represent the values from 0 to 255?

   255 in binary is 11111111, which is 8 bits to store values from 0 to 255.

2. How many bytes does it take to represent a color in the RBG color model?

    Since there are three colors, we need `3 * 8`, which is 3 bytes to store an RGB value.

3. How many pixels are in a picture that is 640 pixels wide and 480 pixels high?

   `640 * 480 = 307,200 ` pixels.

### A2

1. How can you make pink?

   `r=256,g=0,b=256`

2. How can you make yellow?

   `r=256,g=256,b=0`

3. How can you make purple?

   `r=150,g=0,b=256`

4. How can you make white?

   `r=256,g=256,b=256`

5. How can you make dark gray?

   `r=10,g=10,b=10`

### A3

1. What is the row index for the top left corner of the picture? `0`
2. What is the column index for the top left corner of the picture? `0`
3. The width of this picture is 640. What is the right most column index? `640`
4. The height of this picture is 480. What is the bottom most row index? `480`
5. Does the row index increase from left to right or top to bottom? `Top to bottom`
6. Does the column index increase from left to right or top to bottom? `Left to right`

### A5

1. Open Picture.java and look for the method getPixels2D. Is it there? `No`
2. Open SimplePicture.java and look for the method getPixels2D. Is it there? `Yes`
3. Does the following code compile? `No`
  `DigitalPicture p = new DigitalPicture();`
4. Assuming that a no-argument constructor exists for SimplePicture, would the following
  code compile? `Yes`
  `DigitalPicture p = new SimplePicture();`
5. Assuming that a no-argument constructor exists for Picture, does the following code
  compile? `Yes`
  `DigitalPicture p = new Picture();`
6. Assuming that a no-argument constructor exists for Picture, does the following code
  compile? `Yes`
  `SimplePicture p = new Picture();`
7. Assuming that a no-argument constructor exists for SimplePicture, does the following
  code compile? `No`
  `Picture p = new SimplePicture();`

### A7

1. How many times would the body of this nested for loop execute? `90`

  ```Java
  for (int row = 7; row < 17; row++)
      for (int col = 6; col < 15; col++) 
  ```

2. How many times would the body of this nested for loop execute? `112`

  ```Java
  for (int row = 5; row <= 11; row++)
      for (int col = 3; col <= 18; col++)
  ```

  