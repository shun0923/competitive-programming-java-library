---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
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
    PROBLEM: https://yukicoder.me/problems/no/1092
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/1092\n\n\
    package library;\n\nimport library.Solver;\nimport library.ArbitraryMod;\n\npublic\
    \ class ArbitraryModOperation_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new ArbitraryModOperation_test()); }\n\n\tpublic\
    \ void solve() {\n\t\tMod md = new ArbitraryMod(nl());\n\t\tint n = ni() - 1;\n\
    \t\tlong ans = nl();\n\t\tlong a[] = nl(n);\n\t\tfor(long ele : a) {\n\t\t\tswitch(nc())\
    \ {\n\t\t\tcase '+': ans = md.add(ans, ele); break;\n\t\t\tcase '-': ans = md.sub(ans,\
    \ ele); break;\n\t\t\tcase '*': ans = md.mul(ans, ele); break;\n\t\t\tcase '/':\
    \ ans = md.div(ans, ele); break;\n\t\t\t}\n\t\t}\n\t\tprtln(ans);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/ArbitraryMod.java
  isVerificationFile: true
  path: library/ArbitraryModOperation_test.java
  requiredBy: []
  timestamp: '2022-09-20 14:50:17+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/ArbitraryModOperation_test.java
layout: document
redirect_from:
- /verify/library/ArbitraryModOperation_test.java
- /verify/library/ArbitraryModOperation_test.java.html
title: library/ArbitraryModOperation_test.java
---
