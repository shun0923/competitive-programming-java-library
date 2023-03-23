---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/1186
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
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/1186\n\n\
    package library;\n\nimport library.Solver;\nimport library.Mod;\n\npublic class\
    \ Mod998_manyCombination_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new Mod998_manyCombination_test()); }\n\n\tpublic\
    \ void solve() {\n\t\tMod md = Mod998.md;\n\t\tint n = ni();\n\t\tint m = ni();\n\
    \t\tif(n == 1) prtln(1);\n\t\telse {\n\t\t\tlong ans = 0;\n\t\t\tfor(int x = 0;\
    \ x <= m / n; x ++) {\n\t\t\t\tans = md.add(ans, md.H(x + 1, m - x * n));\n\t\t\
    \t}\n\t\t\tprtln(ans);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Mod.java
  isVerificationFile: true
  path: library/Mod998_manyCombination_test.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Mod998_manyCombination_test.java
layout: document
redirect_from:
- /verify/library/Mod998_manyCombination_test.java
- /verify/library/Mod998_manyCombination_test.java.html
title: library/Mod998_manyCombination_test.java
---