---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateSwag.java
    title: library/TemplateSwag.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/1036
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
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/1036\n\n\
    package library;\n\nimport library.Solver;\nimport library.TemplateSwag;\n\npublic\
    \ class TemplateSwag_gcd_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new TemplateSwag_gcd_test()); }\n\n\tpublic void\
    \ solve() {\n\t\tint n = ni();\n\t\tLong a[] = new Long[n];\n\t\tfor(int i = 0;\
    \ i < n; i ++) a[i] = nl();\n\t\tTemplateSwag<Long> swag = new TemplateSwag<>(a,\
    \ () -> 0l, (ele1, ele2) -> gcd(ele1, ele2));\n\t\tlong ans = 0;\n\t\tint r =\
    \ 0;\n\t\tfor(int l = 0; l < n; l ++) {\n\t\t\tfor(; r <= n; r ++) {\n\t\t\t\t\
    if(swag.fold(l, r) == 1) { ans += n - r + 1; break; }\n\t\t\t}\n\t\t}\n\t\tprtln(ans);\n\
    \t}\n}"
  dependsOn:
  - library/Solver.java
  - library/TemplateSwag.java
  isVerificationFile: true
  path: library/TemplateSwag_gcd_test.java
  requiredBy: []
  timestamp: '2022-10-04 10:50:43+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/TemplateSwag_gcd_test.java
layout: document
redirect_from:
- /verify/library/TemplateSwag_gcd_test.java
- /verify/library/TemplateSwag_gcd_test.java.html
title: library/TemplateSwag_gcd_test.java
---
