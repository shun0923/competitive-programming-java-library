---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Convolution.java
    title: library/Convolution.java
  - icon: ':question:'
    path: library/Fps.java
    title: library/Fps.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/polynomial_taylor_shift
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/polynomial_taylor_shift\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Fps;\nimport library.Convolution;\n\
    \npublic class Fps_addComposite_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new Fps_addComposite_test()); }\n\n\tpublic void\
    \ solve() {\n\t\tFpsOperator op = new CnvFpsOperator(Convolution998.cnv);\n\t\t\
    int n = ni();\n\t\tlong c = nl();\n\t\tFps f = new Fps(op, nl(n));\n\t\tprtln(op.addComposite(f,\
    \ c).get());\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Fps.java
  - library/Convolution.java
  isVerificationFile: true
  path: library/Fps_addComposite_test.java
  requiredBy: []
  timestamp: '2022-10-30 19:16:28+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Fps_addComposite_test.java
layout: document
redirect_from:
- /verify/library/Fps_addComposite_test.java
- /verify/library/Fps_addComposite_test.java.html
title: library/Fps_addComposite_test.java
---
