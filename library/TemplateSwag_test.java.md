---
data:
  _extendedDependsOn:
  - icon: ':question:'
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
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_3_D
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/TemplateSwag_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_3_D\n\
    \npackage library;\n\nimport library.Solver;\nimport library.TemplateSwag;\n\n\
    public class TemplateSwag_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new TemplateSwag_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tint n = ni();\n\t\tint l = ni();\n\t\tLong a[] = new Long[n];\n\t\tfor(int\
    \ i = 0; i < n; i ++) a[i] = nl();\n\t\tTemplateSwag<Long> swag = new TemplateSwag<>(a,\
    \ () -> INF, (ele1, ele2) -> min(ele1, ele2));\n\t\tlong ans[] = new long[n -\
    \ l + 1];\n\t\tfor(int i = 0; i + l <= n; i ++) ans[i] = swag.fold(i, i + l);\n\
    \t\tprtln(ans);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/TemplateSwag.java
  isVerificationFile: true
  path: library/TemplateSwag_test.java
  requiredBy: []
  timestamp: '2022-09-21 20:20:08+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/TemplateSwag_test.java
layout: document
redirect_from:
- /verify/library/TemplateSwag_test.java
- /verify/library/TemplateSwag_test.java.html
title: library/TemplateSwag_test.java
---
