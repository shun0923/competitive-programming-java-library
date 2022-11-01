---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Convolution.java
    title: library/Convolution.java
  - icon: ':x:'
    path: library/Fps.java
    title: library/Fps.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/sqrt_of_formal_power_series
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/sqrt_of_formal_power_series\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Fps;\nimport library.Convolution;\n\
    \npublic class Fps_sqrt_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new Fps_sqrt_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tFpsOperator op = new CnvFpsOperator(Convolution998.cnv);\n\t\tint n =\
    \ ni();\n\t\tFps f = new Fps(op, nl(n));\n\t\tFps g = op.sqrt(f);\n\t\tif(g ==\
    \ null) prtln(-1); else prtln(g.get());\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Fps.java
  - library/Convolution.java
  isVerificationFile: true
  path: library/Fps_sqrt_test.java
  requiredBy: []
  timestamp: '2022-11-01 12:07:23+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Fps_sqrt_test.java
layout: document
redirect_from:
- /verify/library/Fps_sqrt_test.java
- /verify/library/Fps_sqrt_test.java.html
title: library/Fps_sqrt_test.java
---
