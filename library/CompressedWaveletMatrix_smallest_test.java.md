---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/CompressedWaveletMatrix.java
    title: library/CompressedWaveletMatrix.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/range_kth_smallest
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/range_kth_smallest\n\
    \npackage library;\n\nimport library.Solver;\nimport library.CompressedWaveletMatrix;\n\
    \npublic class CompressedWaveletMatrix_smallest_test extends Solver {\n\tpublic\
    \ static void main(final String[] args) { main(args, new CompressedWaveletMatrix_smallest_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tWaveletMatrix\
    \ wm = new WaveletMatrix(ni(n));\n\t\tfor(int i = 0; i < q; i ++) prtln(wm.smallest(ni(),\
    \ ni(), ni()));\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/CompressedWaveletMatrix.java
  isVerificationFile: true
  path: library/CompressedWaveletMatrix_smallest_test.java
  requiredBy: []
  timestamp: '2022-10-04 10:50:43+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/CompressedWaveletMatrix_smallest_test.java
layout: document
redirect_from:
- /verify/library/CompressedWaveletMatrix_smallest_test.java
- /verify/library/CompressedWaveletMatrix_smallest_test.java.html
title: library/CompressedWaveletMatrix_smallest_test.java
---
