package numberAnalysis;

import numberAnalysis.Core.F;

/**
 * 函数求积
 *
 * @author ttp
 */
public class Integral {

    /**
     * simpson38 较优的求积算法
     *
     * @param f      函数
     * @param xleft  左端点
     * @param xright 右端点
     * @return 积分结果
     */
    public static double simpson38(F f, double xleft, double xright) {
        double h = (xright - xleft) / 3;
        return 3.0 / 8.0 * h * (
                f.f(xleft) +
                        3 * f.f(xleft + h) +
                        3 * f.f(xleft + 2 * h) +
                        f.f(xleft + 3 * h)
        );
    }

    /**
     * trapezoidF 复合梯形解法，更加灵活
     *
     * @param f      函数
     * @param xleft  左端点
     * @param xright 右端点
     * @param leven  复合 段，值越大精度越高，计算越慢
     * @return 积分结果
     */
    public static double trapezoidF(F f, double xleft, double xright, int leven) {
        double h = (xright - xleft) / leven;
        double res = 0;
        for (int i = 0; i < leven; i++) {
            res += f.f(xleft + h * i);
        }
        return h / 2 * (f.f(xleft) + f.f(xright) + 2 * res);
    }
}
