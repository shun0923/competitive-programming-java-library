---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/Swag.java
    title: library/Swag.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/1036
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/1036\n\n\
    package library;\n\nimport library.Solver;\nimport library.Swag;\n\npublic class\
    \ Swag_gcd_test extends Solver {\n\tpublic static void main(final String[] args)\
    \ { main(args, new Swag_gcd_test()); }\n\n\tpublic void solve() {\n\t\tint n =\
    \ ni();\n\t\tlong a[] = nl(n);\n\t\tSwag swag = new Swag(a, 0, (ele1, ele2) ->\
    \ gcd(ele1, ele2));\n\t\tlong ans = 0;\n\t\tint r = 0;\n\t\tfor(int l = 0; l <\
    \ n; l ++) {\n\t\t\tfor(; r <= n; r ++) {\n\t\t\t\tif(swag.fold(l, r) == 1) {\
    \ ans += n - r + 1; break; }\n\t\t\t}\n\t\t}\n\t\tprtln(ans);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Swag.java
  isVerificationFile: true
  path: library/Swag_gcd_test.java
  requiredBy: []
  timestamp: '2022-09-22 13:24:58+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Swag_gcd_test.java
layout: document
redirect_from:
- /verify/library/Swag_gcd_test.java
- /verify/library/Swag_gcd_test.java.html
title: library/Swag_gcd_test.java
---
