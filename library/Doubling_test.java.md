---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Doubling.java
    title: library/Doubling.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/1211
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/1211\n\n\
    package library;\n\nimport java.util.*;\nimport library.Solver;\nimport library.Doubling;\n\
    \npublic class Doubling_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new Doubling_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tint n = ni();\n\t\tint k = ni();\n\t\tlong a[] = new long[n * 2];\n\t\
    \tfor(int i = 0; i < n; i ++) { a[i] = ni(); a[n + i] = a[i]; }\n\t\tn *= 2;\n\
    \t\tint edges[] = new int[n + 1];\n\t\tDoubling db;\n\t\tlong ok = 0;\n\t\tlong\
    \ ng = sum(a) + 1;\n\t\twhile(abs(ok - ng) > 1) {\n\t\t\tlong mid = ng + (ok -\
    \ ng) / 2;\n\t\t\tArrays.fill(edges, -1);\n\t\t\tlong sum = 0;\n\t\t\tint r =\
    \ 0;\n\t\t\tfor(int l = 0; l < n; l ++) {\n\t\t\t\tfor(; r < n; r ++) {\n\t\t\t\
    \t\tif(sum >= mid) break;\n\t\t\t\t\tsum += a[r];\n\t\t\t\t}\n\t\t\t\tif(sum >=\
    \ mid) edges[l] = r;\n\t\t\t\tsum -= a[l];\n\t\t\t}\n\t\t\tdb = new Doubling(n\
    \ + 1, k, edges);\n\t\t\tboolean isOK = false;\n\t\t\tfor(int i = 0; i < n; i\
    \ ++) {\n\t\t\t\tint to = db.cal(i, k);\n\t\t\t\tisOK |= to != -1 && to <= i +\
    \ n / 2;\n\t\t\t}\n\t\t\tif(isOK) ok = mid;\n\t\t\telse ng = mid;\n\t\t}\n\t\t\
    prtln(ok);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Doubling.java
  isVerificationFile: true
  path: library/Doubling_test.java
  requiredBy: []
  timestamp: '2022-10-04 19:27:54+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Doubling_test.java
layout: document
redirect_from:
- /verify/library/Doubling_test.java
- /verify/library/Doubling_test.java.html
title: library/Doubling_test.java
---
