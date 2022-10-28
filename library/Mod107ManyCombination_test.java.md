---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/1044
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/1044\n\n\
    package library;\n\nimport library.Solver;\nimport library.Mod;\n\npublic class\
    \ Mod107ManyCombination_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new Mod107ManyCombination_test()); }\n\n\tpublic\
    \ void solve() {\n\t\tMod md = Mod107.md;\n\t\tint n = ni();\n\t\tint m = ni();\n\
    \t\tint k = ni();\n\t\tlong ans = 0;\n\t\tfor(int x = 1; x <= n && x <= m && x\
    \ <= (n + m - k) / 2; x ++) {\n\t\t\tans = md.add(ans, md.mul(md.C(n, x), md.H(x,\
    \ m - x)));\n\t\t}\n\t\tprtln(md.mul(ans, md.fact(m), md.fact(n - 1)));\n\t}\n\
    }"
  dependsOn:
  - library/Solver.java
  - library/Mod.java
  isVerificationFile: true
  path: library/Mod107ManyCombination_test.java
  requiredBy: []
  timestamp: '2022-10-04 10:50:43+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Mod107ManyCombination_test.java
layout: document
redirect_from:
- /verify/library/Mod107ManyCombination_test.java
- /verify/library/Mod107ManyCombination_test.java.html
title: library/Mod107ManyCombination_test.java
---
