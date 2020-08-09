package com.parrypatel.databindingdemo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Thanks to: https://denofdevelopers.com/base64-string-to-image-example/
 */

public class Base64Util {

    /**
     * Usage
     */
    //String base64String = "iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAMAAADW3miqAAAABGdBTUEAAK/INwWK6QAAABl0RVh0U29mdHdhcmUAQWRvYmUgSW1hZ2VSZWFkeXHJZTwAAAKmUExURUOCukSFukKAukaHu0F9uT98uT55uD13uDtyt02VvTx0t1Cbvjx2uFenwFWkwDpxt0uSvU6YvlqswFOhv1uvwVipwF60wV2xwVKev0eKu1+2wWG5wVGev2K7wVmpwFKhv/T4+0uGvWO9wTlwt+zy+EiNvPz9/tXl70qPvePs9a3e3vf6/OHu9EaDvEqQvfb5/H6yz5S02N/p8/v9/ladwcze7FmHw3e+y2GVxejv9urz9/n8/XDDxp3A27rh5Ed+vP3+/tXi8KK83eDu9FqqwI681WWTx5m52ZW+2FaWwdzn8vP6+sXj6V+pxNPh70Z+u9Tm78/d7dHm7t/v86nJ39/q85DP06LE3WeUyIK90FSfwI3L02KRxtzp8sbW6t7p88DS6GiSyMDX6N3x8WOcxY/E1Xyvz4/J1FWMwOXt9VelwcDi59Hf7trv8fr7/fv8/mybyVOXwOvx+N7v8nSnzHWmzGKUxmS+wUN+unHCx0R/ukWDu2WQx1KCwFKVwHabzUWAu9Lo7kN/uuzz+Mbf6liTwtTn77jL5VOEv46+1WCLxZ2524u31Onw94Oz0ub19dvn8p7F20F2upG31l2dxIeu00uQvWypyYCs0I7B1fb7+9jm8VWgwFWTwFmHwk1/vbvR5u/1+YOy0rTf4X2v0GmjyEV5vFmSwoi+05DH1Vyvwe71+ZWy2NPj75Sx2I6x1mOTxnm8zGylyYm01JfD2E+UvnSdzGGOxVSEwUV7uuT09EuNvb7X51Gav3+2z0V4u3ezzcjd6/L1+rnO5UaEu4+01vL2+tTo7+30+V+bxEmEvHurznO/yfL3+vP3+/D0+ZXS1NHg7uDs9ODu84+x1rDO4tLj7u3y+H+50Ka/3rrW5WbAwd3o8/7+/o2x1Xulz9zv8f///5WduusAAADidFJOU////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////wBwHrofAAACYUlEQVR42mJ4iAG0+tFFAAKIAUPNrtta6EIAAYSp6EK5jTeaEEAAYShKVlJSWowmBhBAGIrCZGVlK2ehigEEELqiXGkQsEMVBAggdEXRUiBwxhpFECCA0BQ9EIOAbBRRgABCU5QuDgHmxsiiAAGEqqh4lQgU+CALAwQQqqKVQjCwEVkYIIBQFAW7iIqKysmBCNFGJHGAAEJRlMqLAJFI4gABhKzochYfCPiCSb7jCAmAAEJWNFNYXlhYWD5ohTCIcQMhARBASIqcoyRkJCRkDjzUmQNmtMFlAAIISVEnNxi0PHy4BczYB5cBCCCEIp29giAwXe3hQysTMDMAJgUQQAhFrpxgcAvEnghmGsCkAAIIrujSVgEQmKIN4pwoBHPUoXIAAQRTdHeJhobnpj6PgxDunqV10/T00qCSAAEEU7S656r6Qpipamebr4UsOqmquhbCBwggtFSgEJsUvrkkZe5uSTA4DREFCCAkRQqmtqWtzKhgNlgGIIDgiiZMXs6ICWaA5QACCKro2NEjDNhA9R2QLEAAQRSFWjAhA91TioqKumDmVJA0QACBFWlmsEBBU4H7govxmb1FKip+VSCBBk2gPEAAgRTpl7FCQMV6LySf3geL3QOyAAIIpOgKGwRscEQJjkCwoL/lw4cAAQRUlMMOAdsU0PKgG1jY8OFDgABieOgQwQMGMfroOf4wWNz++kOAAGJ4mMAFBjuNMMoX7Q6wTPdDgABiyN/OAQY3MUuzh05gmfnnAQKIoZ0fDOblYVF0rgYstw4ggBi6lJWVJ9Umxj3EBg6tMdu/bEc9QIABAG5tGRBqDEH5AAAAAElFTkSuQmCC";
    //imageView.setImageBitmap(Base64Util.convertStringToBitmap(base64String));



    private static final int IMG_WIDTH = 640;
    private static final int IMG_HEIGHT = 480;

    private static String resizeBase64Image(String base64image) {
        byte[] encodeByte = Base64.decode(base64image.getBytes(), Base64.DEFAULT);
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap image = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length, options);

        if (image.getHeight() <= 400 && image.getWidth() <= 400) {
            return base64image;
        }
        image = Bitmap.createScaledBitmap(image, IMG_WIDTH, IMG_HEIGHT, false);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, baos);

        byte[] b = baos.toByteArray();
        System.gc();
        return Base64.encodeToString(b, Base64.NO_WRAP);
    }

    private static Bitmap convertString64ToImage(String base64String) {
        byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    public static Bitmap convertStringToBitmap(String base64String) {
        return convertString64ToImage(resizeBase64Image(base64String));
    }

}
