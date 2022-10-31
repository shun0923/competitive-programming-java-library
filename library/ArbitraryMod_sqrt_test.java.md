---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/ArbitraryMod.java
    title: library/ArbitraryMod.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/sqrt_mod
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/sqrt_mod\n\
    \npackage library;\n\nimport library.Solver;\nimport library.ArbitraryMod;\n\n\
    public class ArbitraryMod_sqrt_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new ArbitraryMod_sqrt_test()); }\n\n\tpublic void\
    \ solve() {\n\t\tint t = ni();\n\t\tfor(int i = 0; i < t; i ++) {\n\t\t\tlong\
    \ y = nl();\n\t\t\tlong p = nl();\n\t\t\tprtln(new ArbitraryMod(p).sqrt(y));\n\
    \t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/ArbitraryMod.java
  isVerificationFile: true
  path: library/ArbitraryMod_sqrt_test.java
  requiredBy: []
  timestamp: '2022-10-31 15:25:53+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/ArbitraryMod_sqrt_test.java
layout: document
redirect_from:
- /verify/library/ArbitraryMod_sqrt_test.java
- /verify/library/ArbitraryMod_sqrt_test.java.html
title: library/ArbitraryMod_sqrt_test.java
---