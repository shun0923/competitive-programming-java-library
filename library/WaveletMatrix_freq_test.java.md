---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/WaveletMatrix.java
    title: library/WaveletMatrix.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2674
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
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2674\n\
    \npackage library;\n\nimport library.Solver;\nimport library.WaveletMatrix;\n\n\
    public class WaveletMatrix_freq_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new WaveletMatrix_freq_test()); }\n\n\tpublic void\
    \ solve() {\n\t\tint d = ni();\n\t\tint x[] = ni(d);\n\t\tfor(int i = 0; i < d;\
    \ i ++) x[i] += 100_000_000;\n\t\tWaveletMatrix wm = new WaveletMatrix(x);\n\t\
    \tint q = ni();\n\t\tfor(int i = 0; i < q; i ++) {\n\t\t\tint l = ni() - 1;\n\t\
    \t\tint r = ni() - 1;\n\t\t\tint e = ni();\n\t\t\tprtln(r - l + 1 - wm.rangeFreq(min(x[l],\
    \ x[r]) - e, max(x[l], x[r]) + e + 1, l, r + 1));\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/WaveletMatrix.java
  isVerificationFile: true
  path: library/WaveletMatrix_freq_test.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/WaveletMatrix_freq_test.java
layout: document
redirect_from:
- /verify/library/WaveletMatrix_freq_test.java
- /verify/library/WaveletMatrix_freq_test.java.html
title: library/WaveletMatrix_freq_test.java
---
