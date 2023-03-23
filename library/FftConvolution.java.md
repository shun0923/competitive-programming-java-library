---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport library.SimpleUtil;\n\nclass FftConvolution {\n\
    \tpublic static final double[][] butterfly(double[][] f, boolean inv){ // O(NlogN)\n\
    \t\tint n = f.length;\n\t\tif(n <= 1) return f;\n\t\tint bit = 0;\n\t\tint digit\
    \ = 0;\n\t\tint n2 = n;\n\t\twhile(n2 > 1) { n2 /= 2; digit ++; }\n\t\tfor(int\
    \ i = 1; i < n; i ++) {\n\t\t\tfor(int j = digit - 1; j >= 0; j --) {\n\t\t\t\t\
    if((bit >> j & 1) != 0) bit &= ~(1 << j);\n\t\t\t\telse { bit |= 1 << j; break;\
    \ }\n\t\t\t}\n\t\t\tif(i < bit) {\n\t\t\t\tdouble tmp[] = {f[i][0], f[i][1]};\n\
    \t\t\t\tf[i][0] = f[bit][0];\n\t\t\t\tf[i][1] = f[bit][1];\n\t\t\t\tf[bit][0]\
    \ = tmp[0];\n\t\t\t\tf[bit][1] = tmp[1];\n\t\t\t}\n\t\t}\n\t\tfor(int i = 1; i\
    \ <= digit; i ++) {\n\t\t\tint len = 1 << i;\n\t\t\tdouble theta = 2.0 * Math.PI\
    \ / len * (inv ? -1 : 1);\n\t\t\tdouble z[] = {Math.cos(theta), Math.sin(theta)};\n\
    \t\t\tfor(int j = 0; j < n; j += len) {\n\t\t\t\tdouble pow[] = {1, 0};\n\t\t\t\
    \tfor(int k = 0; k < len >> 1; k ++) {\n\t\t\t\t\tdouble f0[] = {f[j + k][0],\
    \ f[j + k][1]};\n\t\t\t\t\tdouble f1[] = {f[j + k + (len >> 1)][0], f[j + k +\
    \ (len >> 1)][1]};\n\t\t\t\t\tf[j + k + len / 2][0] = f0[0];\n\t\t\t\t\tf[j +\
    \ k + len / 2][1] = f0[1];\n\n\t\t\t\t\tdouble a = f1[0] * pow[0] - f1[1] * pow[1];\n\
    \t\t\t\t\tdouble b = f1[0] * pow[1] + f1[1] * pow[0];\n\t\t\t\t\tf1[0] = a;\n\t\
    \t\t\t\tf1[1] = b;\n\n\t\t\t\t\tf[j + k][0] += f1[0];\n\t\t\t\t\tf[j + k][1] +=\
    \ f1[1];\n\t\t\t\t\tf[j + k + (len >> 1)][0] -= f1[0];\n\t\t\t\t\tf[j + k + (len\
    \ >> 1)][1] -= f1[1];\n\n\t\t\t\t\ta = pow[0] * z[0] - pow[1] * z[1];\n\t\t\t\t\
    \tb = pow[0] * z[1] + pow[1] * z[0];\n\t\t\t\t\tpow[0] = a;\n\t\t\t\t\tpow[1]\
    \ = b;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn f;\n\t}\n\n\t// O((N_1+N_2)log(N_1+N_2))\n\
    \tpublic static final long[] cnv(final long[] a, final long[] b) { return cnv(a,\
    \ b, Math.max(0, a.length + b.length - 1)); }\n\tpublic static final long[] cnv(final\
    \ long[] a, final long[] b, final int l) {\n\t\tSimpleUtil.nonNegativeCheck(l);\n\
    \t\tif(a.length == 0 || b.length == 0) return new long[l];\n\t\tint len = 1;\n\
    \t\twhile(len < a.length + b.length - 1) len <<= 1;\n\t\tdouble g[][] = new double[len][2];\n\
    \t\tdouble h[][] = new double[len][2];\n\t\tfor(int i = 0; i < a.length; i ++)\
    \ {\n\t\t\tg[i][0] = a[i];\n\t\t\tg[i][1] = 0;\n\t\t}\n\t\tfor(int i = 0; i <\
    \ b.length; i ++) {\n\t\t\th[i][0] = b[i];\n\t\t\th[i][1] = 0;\n\t\t}\n\t\tg =\
    \ butterfly(g, false);\n\t\th = butterfly(h, false);\n\t\tdouble f[][] = new double[len][2];\n\
    \t\tfor(int i = 0; i < len; i ++) {\n\t\t\tf[i][0] = g[i][0] * h[i][0] - g[i][1]\
    \ * h[i][1];\n\t\t\tf[i][1] = g[i][0] * h[i][1] + g[i][1] * h[i][0];\n\t\t}\n\t\
    \tf = butterfly(f, true);\n\t\tlong ans[] = new long[l];\n\t\tfor(int i = 0; i\
    \ < l; i ++) {\n\t\t\tans[i] = Math.round(f[i][0] / len);\n\t\t}\n\t\treturn ans;\n\
    \t}\n}"
  dependsOn: []
  isVerificationFile: false
  path: library/FftConvolution.java
  requiredBy: []
  timestamp: '2023-03-23 19:02:13+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/FftConvolution.java
layout: document
redirect_from:
- /library/library/FftConvolution.java
- /library/library/FftConvolution.java.html
title: library/FftConvolution.java
---
