---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateSegmentTree.java
    title: library/TemplateSegmentTree.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/point_add_range_sum
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/TemplateSegmentTree_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_add_range_sum\n\
    \npackage library;\n\nimport library.Solver;\nimport library.TemplateSegmentTree;\n\
    \npublic class TemplateSegmentTree_test extends Solver {\n\tpublic static void\
    \ main(final String[] args) { main(args, new TemplateSegmentTree_test()); }\n\n\
    \tpublic void solve() {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tLong a[] =\
    \ new Long[n];\n\t\tfor(int i = 0; i < n; i ++) a[i] = nl();\n\t\tTemplateSegmentTree<Long>\
    \ st = new TemplateSegmentTree<>(a,\n\t\t\t\t() -> 0l, (ele1, ele2) -> ele1 +\
    \ ele2);\n\t\tfor(int i = 0; i < q; i ++) {\n\t\t\tif(ni() == 0) st.update(ni(),\
    \ nl());\n\t\t\telse prtln(st.find(ni(), ni()));\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/TemplateSegmentTree.java
  isVerificationFile: true
  path: library/TemplateSegmentTree_test.java
  requiredBy: []
  timestamp: '2022-09-20 18:17:06+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/TemplateSegmentTree_test.java
layout: document
redirect_from:
- /verify/library/TemplateSegmentTree_test.java
- /verify/library/TemplateSegmentTree_test.java.html
title: library/TemplateSegmentTree_test.java
---
