---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/DynamicSegmentTree.java
    title: library/DynamicSegmentTree.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/point_add_range_sum
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
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_add_range_sum\n\
    \npackage library;\n\nimport library.Solver;\nimport library.DynamicSegmentTree;\n\
    \npublic class DynamicSegmentTree_small_test extends Solver {\n\tpublic static\
    \ void main(final String[] args) { main(args, new DynamicSegmentTree_small_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tDynamicSegmentTree\
    \ st = new DynamicSegmentTree(n,\n\t\t\t\t0, (ele1, ele2) -> ele1 + ele2);\n\t\
    \tfor(int i = 0; i < n; i ++) st.set(i, nl());\n\t\tfor(int i = 0; i < q; i ++)\
    \ {\n\t\t\tif(ni() == 0) st.update(ni(), nl());\n\t\t\telse prtln(st.find(ni(),\
    \ ni()));\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/DynamicSegmentTree.java
  isVerificationFile: true
  path: library/DynamicSegmentTree_small_test.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/DynamicSegmentTree_small_test.java
layout: document
redirect_from:
- /verify/library/DynamicSegmentTree_small_test.java
- /verify/library/DynamicSegmentTree_small_test.java.html
title: library/DynamicSegmentTree_small_test.java
---