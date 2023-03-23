---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':x:'
    path: library/TemplateDynamicSegmentTree.java
    title: library/TemplateDynamicSegmentTree.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://yukicoder.me/problems/no/789
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
  code: "// verification-helper: PROBLEM https://yukicoder.me/problems/no/789\n\n\
    package library;\n\nimport library.Solver;\nimport library.TemplateDynamicSegmentTree;\n\
    \npublic class TemplateDynamicSegmentTree_test extends Solver {\n\tpublic static\
    \ void main(final String[] args) { main(args, new TemplateDynamicSegmentTree_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tTemplateDynamicSegmentTree<Long>\
    \ st = new TemplateDynamicSegmentTree<>(1_000_000_001,\n\t\t\t\t() -> 0l, (ele1,\
    \ ele2) -> ele1 + ele2);\n\t\tlong ans = 0;\n\t\tfor(int i = 0; i < n; i ++) {\n\
    \t\t\tif(ni() == 0) st.update(ni(), nl());\n\t\t\telse ans += st.find(ni(), ni()\
    \ + 1);\n\t\t}\n\t\tprtln(ans);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/TemplateDynamicSegmentTree.java
  isVerificationFile: true
  path: library/TemplateDynamicSegmentTree_test.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/TemplateDynamicSegmentTree_test.java
layout: document
redirect_from:
- /verify/library/TemplateDynamicSegmentTree_test.java
- /verify/library/TemplateDynamicSegmentTree_test.java.html
title: library/TemplateDynamicSegmentTree_test.java
---
